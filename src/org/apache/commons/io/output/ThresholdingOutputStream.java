package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

public abstract class ThresholdingOutputStream extends OutputStream {
  private int threshold;
  
  private long written;
  
  private boolean thresholdExceeded;
  
  public ThresholdingOutputStream(int threshold) {
    this.threshold = threshold;
  }
  
  public void write(int b) throws IOException {
    checkThreshold(1);
    getStream().write(b);
    this.written++;
  }
  
  public void write(byte[] b) throws IOException {
    checkThreshold(b.length);
    getStream().write(b);
    this.written += b.length;
  }
  
  public void write(byte[] b, int off, int len) throws IOException {
    checkThreshold(len);
    getStream().write(b, off, len);
    this.written += len;
  }
  
  public void flush() throws IOException {
    getStream().flush();
  }
  
  public void close() throws IOException {
    try {
      flush();
    } catch (IOException ignored) {}
    getStream().close();
  }
  
  public int getThreshold() {
    return this.threshold;
  }
  
  public long getByteCount() {
    return this.written;
  }
  
  public boolean isThresholdExceeded() {
    return (this.written > this.threshold);
  }
  
  protected void checkThreshold(int count) throws IOException {
    if (!this.thresholdExceeded && this.written + count > this.threshold) {
      thresholdReached();
      this.thresholdExceeded = true;
    } 
  }
  
  protected abstract OutputStream getStream() throws IOException;
  
  protected abstract void thresholdReached() throws IOException;
}
