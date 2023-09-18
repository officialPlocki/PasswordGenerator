package org.apache.commons.io.filefilter;

import java.io.File;

public class TrueFileFilter implements IOFileFilter {
  public static final IOFileFilter TRUE = new org.apache.commons.io.filefilter.TrueFileFilter();
  
  public static final IOFileFilter INSTANCE = TRUE;
  
  public boolean accept(File file) {
    return true;
  }
  
  public boolean accept(File dir, String name) {
    return true;
  }
}
