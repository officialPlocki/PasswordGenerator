package org.apache.commons.io.input;

import java.io.*;

public class ClassLoaderObjectInputStream extends ObjectInputStream {
  private ClassLoader classLoader;
  
  public ClassLoaderObjectInputStream(ClassLoader classLoader, InputStream inputStream) throws IOException, StreamCorruptedException {
    super(inputStream);
    this.classLoader = classLoader;
  }
  
  protected Class resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
    Class clazz = Class.forName(objectStreamClass.getName(), false, this.classLoader);
    if (clazz != null)
      return clazz; 
    return super.resolveClass(objectStreamClass);
  }
}
