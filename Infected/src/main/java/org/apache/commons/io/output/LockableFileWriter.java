package org.apache.commons.io.output;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class LockableFileWriter extends Writer {
  private static final String LCK = ".lck";
  
  private final Writer out;
  
  private final File lockFile;
  
  public LockableFileWriter(String fileName) throws IOException {
    this(fileName, false, (String)null);
  }
  
  public LockableFileWriter(String fileName, boolean append) throws IOException {
    this(fileName, append, (String)null);
  }
  
  public LockableFileWriter(String fileName, boolean append, String lockDir) throws IOException {
    this(new File(fileName), append, lockDir);
  }
  
  public LockableFileWriter(File file) throws IOException {
    this(file, false, (String)null);
  }
  
  public LockableFileWriter(File file, boolean append) throws IOException {
    this(file, append, (String)null);
  }
  
  public LockableFileWriter(File file, boolean append, String lockDir) throws IOException {
    this(file, null, append, lockDir);
  }
  
  public LockableFileWriter(File file, String encoding) throws IOException {
    this(file, encoding, false, null);
  }
  
  public LockableFileWriter(File file, String encoding, boolean append, String lockDir) throws IOException {
    file = file.getAbsoluteFile();
    if (file.getParentFile() != null)
      FileUtils.forceMkdir(file.getParentFile()); 
    if (file.isDirectory())
      throw new IOException("File specified is a directory"); 
    if (lockDir == null)
      lockDir = System.getProperty("java.io.tmpdir"); 
    File lockDirFile = new File(lockDir);
    FileUtils.forceMkdir(lockDirFile);
    testLockDir(lockDirFile);
    this.lockFile = new File(lockDirFile, file.getName() + ".lck");
    createLock();
    this.out = initWriter(file, encoding, append);
  }
  
  private void testLockDir(File lockDir) throws IOException {
    if (!lockDir.exists())
      throw new IOException("Could not find lockDir: " + lockDir.getAbsolutePath()); 
    if (!lockDir.canWrite())
      throw new IOException("Could not write to lockDir: " + lockDir.getAbsolutePath()); 
  }
  
  private void createLock() throws IOException {
    synchronized (org.apache.commons.io.output.LockableFileWriter.class) {
      if (!this.lockFile.createNewFile())
        throw new IOException("Can't write file, lock " + this.lockFile.getAbsolutePath() + " exists"); 
      this.lockFile.deleteOnExit();
    } 
  }
  
  private Writer initWriter(File file, String encoding, boolean append) throws IOException {
    boolean fileExistedAlready = file.exists();
    OutputStream stream = null;
    Writer writer = null;
    try {
      if (encoding == null) {
        writer = new FileWriter(file.getAbsolutePath(), append);
      } else {
        stream = new FileOutputStream(file.getAbsolutePath(), append);
        writer = new OutputStreamWriter(stream, encoding);
      } 
    } catch (IOException ex) {
      IOUtils.closeQuietly(writer);
      IOUtils.closeQuietly(stream);
      this.lockFile.delete();
      if (!fileExistedAlready)
        file.delete(); 
      throw ex;
    } catch (RuntimeException ex) {
      IOUtils.closeQuietly(writer);
      IOUtils.closeQuietly(stream);
      this.lockFile.delete();
      if (!fileExistedAlready)
        file.delete(); 
      throw ex;
    } 
    return writer;
  }
  
  public void close() throws IOException {
    try {
      this.out.close();
    } finally {
      this.lockFile.delete();
    } 
  }
  
  public void write(int idx) throws IOException {
    this.out.write(idx);
  }
  
  public void write(char[] chr) throws IOException {
    this.out.write(chr);
  }
  
  public void write(char[] chr, int st, int end) throws IOException {
    this.out.write(chr, st, end);
  }
  
  public void write(String str) throws IOException {
    this.out.write(str);
  }
  
  public void write(String str, int st, int end) throws IOException {
    this.out.write(str, st, end);
  }
  
  public void flush() throws IOException {
    this.out.flush();
  }
}
