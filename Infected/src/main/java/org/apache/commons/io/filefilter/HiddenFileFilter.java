package org.apache.commons.io.filefilter;

import java.io.File;

public class HiddenFileFilter extends AbstractFileFilter {
  public static final IOFileFilter HIDDEN = new org.apache.commons.io.filefilter.HiddenFileFilter();
  
  public static final IOFileFilter VISIBLE = new NotFileFilter(HIDDEN);
  
  public boolean accept(File file) {
    return file.isHidden();
  }
}
