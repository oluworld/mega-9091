package tripleo.fs;

import java.io.*;
import java.net.*;

public class File {

    private final java.io.File _carrier;
    final public static char separatorChar = java.io.File.separatorChar;
    final public static String separator = java.io.File.separator;
    final public static String pathSeparator = java.io.File.pathSeparator;

    public File(File f1, String s2) {
        _carrier = new java.io.File(f1.get(), s2);
    }

    public File(String pathname) {
        _carrier = new java.io.File(pathname);
    }

    public File(String parent, String child) {
        _carrier = new java.io.File(parent, child);
    }

    public File(java.io.File parent, String child) {
        _carrier = new java.io.File(parent, child);
    }

    public File(URI uri) {
        _carrier = new java.io.File(uri);
    }

    public String getName() {
        return _carrier.getName();
    }

    public String getParent() {
        return _carrier.getParent();
    }

    public java.io.File getParentFile() {
        return _carrier.getParentFile();
    }

    public String getPath() {
        return _carrier.getPath();
    }

    public boolean isAbsolute() {
        return _carrier.isAbsolute();
    }

    public String getAbsolutePath() {
        return _carrier.getAbsolutePath();
    }

    public java.io.File getAbsoluteFile() {
        return _carrier.getAbsoluteFile();
    }

    public String getCanonicalPath() throws IOException {
        return _carrier.getCanonicalPath();
    }

    public java.io.File getCanonicalFile() throws IOException {
        return _carrier.getCanonicalFile();
    }

    public URL toURL() throws MalformedURLException {
        return _carrier.toURL();
    }

    public URI toURI() {
        return _carrier.toURI();
    }

    public boolean canRead() {
        return _carrier.canRead();
    }

    public boolean canWrite() {
        return _carrier.canWrite();
    }

    public boolean exists() {
        return _carrier.exists();
    }

    public boolean isDirectory() {
        return _carrier.isDirectory();
    }

    public boolean get_carrier() {
        return _carrier.isFile();
    }

    public boolean isHidden() {
        return _carrier.isHidden();
    }

    public long lastModified() {
        return _carrier.lastModified();
    }

    public long length() {
        return _carrier.length();
    }

    public boolean createNewFile() throws IOException {
        return _carrier.createNewFile();
    }

    public boolean delete() {
        return _carrier.delete();
    }

    public void deleteOnExit() {
        _carrier.deleteOnExit();
    }

    public String[] list() {
        return _carrier.list();
    }

    public String[] list(FilenameFilter filter) {
        return _carrier.list(filter);
    }

    public java.io.File[] listFiles() {
        return _carrier.listFiles();
    }

    public java.io.File[] listFiles(FilenameFilter filter) {
        return _carrier.listFiles(filter);
    }

    public java.io.File[] listFiles(FileFilter filter) {
        return _carrier.listFiles(filter);
    }

    public boolean mkdir() {
        return _carrier.mkdir();
    }

    public boolean mkdirs() {
        return _carrier.mkdirs();
    }

    public boolean renameTo(java.io.File dest) {
        return _carrier.renameTo(dest);
    }

    public boolean setLastModified(long time) {
        return _carrier.setLastModified(time);
    }

    public boolean setReadOnly() {
        return _carrier.setReadOnly();
    }

    public int compareTo(java.io.File pathname) {
        return _carrier.compareTo(pathname);
    }

    public boolean equals(Object obj) {
        return _carrier.equals(obj);
    }

    public int hashCode() {
        return _carrier.hashCode();
    }

    public String toString() {
        return _carrier.toString();
    }

    public boolean isFile() {
        return _carrier.isFile();
    }

    public boolean renameTo(File aF2) {
        return _carrier.renameTo(aF2._carrier);
    }

    public java.io.File get() {
        return _carrier;
    }

    public FileOutputStream fos() throws FileNotFoundException {
        return new FileOutputStream(get());
    }

    public FileInputStream fis() throws FileNotFoundException {
        return new FileInputStream(get());
    }
}
