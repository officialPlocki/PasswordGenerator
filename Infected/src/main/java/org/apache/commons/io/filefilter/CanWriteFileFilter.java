package org.apache.commons.io.filefilter;

import java.io.File;

public class CanWriteFileFilter extends AbstractFileFilter {
  public static final IOFileFilter CAN_WRITE = new org.apache.commons.io.filefilter.CanWriteFileFilter();
  
  public static final IOFileFilter CANNOT_WRITE = new NotFileFilter(CAN_WRITE);
  
  public boolean accept(File file) {
    return file.canWrite();
  }
}
