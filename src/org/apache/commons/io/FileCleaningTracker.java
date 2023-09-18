package org.apache.commons.io;

import java.io.File;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collection;
import java.util.Vector;

public class FileCleaningTracker {
  ReferenceQueue q = new ReferenceQueue();
  
  final Collection trackers = new Vector();
  
  volatile boolean exitWhenFinished = false;
  
  Thread reaper;
  
  public void track(File file, Object marker) {
    track(file, marker, (FileDeleteStrategy)null);
  }
  
  public void track(File file, Object marker, FileDeleteStrategy deleteStrategy) {
    if (file == null)
      throw new NullPointerException("The file must not be null"); 
    addTracker(file.getPath(), marker, deleteStrategy);
  }
  
  public void track(String path, Object marker) {
    track(path, marker, (FileDeleteStrategy)null);
  }
  
  public void track(String path, Object marker, FileDeleteStrategy deleteStrategy) {
    if (path == null)
      throw new NullPointerException("The path must not be null"); 
    addTracker(path, marker, deleteStrategy);
  }
  
  private synchronized void addTracker(String path, Object marker, FileDeleteStrategy deleteStrategy) {
    if (this.exitWhenFinished)
      throw new IllegalStateException("No new trackers can be added once exitWhenFinished() is called"); 
    if (this.reaper == null) {
      this.reaper = new Reaper(this);
      this.reaper.start();
    } 
    this.trackers.add(new Tracker(path, deleteStrategy, marker, this.q));
  }
  
  public int getTrackCount() {
    return this.trackers.size();
  }
  
  public synchronized void exitWhenFinished() {
    this.exitWhenFinished = true;
    if (this.reaper != null)
      synchronized (this.reaper) {
        this.reaper.interrupt();
      }  
  }
  
  private final class Reaper extends Thread {
    private final FileCleaningTracker this$0;
    
    Reaper(FileCleaningTracker this$0) {
      super("File Reaper");
      this.this$0 = this$0;
      setPriority(10);
      setDaemon(true);
    }
    
    public void run() {
      while (!this.this$0.exitWhenFinished || this.this$0.trackers.size() > 0) {
        Tracker tracker = null;
        try {
          tracker = (Tracker)this.this$0.q.remove();
        } catch (Exception e) {
          continue;
        } 
        if (tracker != null) {
          tracker.delete();
          tracker.clear();
          this.this$0.trackers.remove(tracker);
        } 
      } 
    }
  }
  
  private static final class Tracker extends PhantomReference {
    private final String path;
    
    private final FileDeleteStrategy deleteStrategy;
    
    Tracker(String path, FileDeleteStrategy deleteStrategy, Object marker, ReferenceQueue queue) {
      super(marker, queue);
      this.path = path;
      this.deleteStrategy = (deleteStrategy == null) ? FileDeleteStrategy.NORMAL : deleteStrategy;
    }
    
    public boolean delete() {
      return this.deleteStrategy.deleteQuietly(new File(this.path));
    }
  }
}
