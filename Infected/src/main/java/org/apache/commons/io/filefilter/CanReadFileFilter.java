package org.apache.commons.io.filefilter;

import java.io.File;

public class CanReadFileFilter extends AbstractFileFilter {
  public static final IOFileFilter CAN_READ = new org.apache.commons.io.filefilter.CanReadFileFilter();
  
  public static final IOFileFilter CANNOT_READ = new NotFileFilter(CAN_READ);
  
  public static final IOFileFilter READ_ONLY = new AndFileFilter(CAN_READ, CanWriteFileFilter.CANNOT_WRITE);
  
  public boolean accept(File file) {
    return file.canRead();
  }
}
