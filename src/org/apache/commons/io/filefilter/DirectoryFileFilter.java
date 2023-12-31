package org.apache.commons.io.filefilter;

import java.io.File;

public class DirectoryFileFilter extends AbstractFileFilter {
  public static final IOFileFilter DIRECTORY = new DirectoryFileFilter();
  
  public static final IOFileFilter INSTANCE = DIRECTORY;
  
  public boolean accept(File file) {
    return file.isDirectory();
  }
}
