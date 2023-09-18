package org.apache.commons.io.filefilter;

import java.io.File;

public class FileFileFilter extends AbstractFileFilter {
  public static final IOFileFilter FILE = new org.apache.commons.io.filefilter.FileFileFilter();
  
  public boolean accept(File file) {
    return file.isFile();
  }
}
