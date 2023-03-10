package DesignInMemoryFileSystem_588;

import java.util.*;

/**
 * ls() Time Complexity: O(path.length() + files count * log(files count))
 * mkdir() Time Complexity: O(path.length())
 * addContentToFile() Time Complexity: O(path.length() + content.length())
 * readContentFromFile() Time Complexity: O(path.length())
 * Runtime: 38ms
 * Rank: 88.03%
 */

public class FileSystem {
    // Important constraints:
    // path and filePath are absolute paths which begin with '/' and do not end with '/' except that the path is just "/".
    // You can assume that all directory names and file names only contain lowercase letters, and the same names will not exist in the same directory.
    // You can assume that all operations will be passed valid parameters, and users will not attempt to retrieve file content or list a directory or file that does not exist.
    // (inputs are always valid)
    private class File {
        public String name;
        public boolean isDir;
        public Map<String, File> children;
        public StringBuilder content;
        public File(String name, boolean isDir) {
            this.name = name;
            this.isDir = isDir;
            this.children = new HashMap<>();
            this.content = new StringBuilder();
        }
    }

    private final File root = new File("/", true);

    public FileSystem() {

    }

    private File get(String path, boolean lastDir) {
        if (path.equals("/")) {
            return root;
        }
        String[] parts = path.split("/");
        File cur = root;
        for (int i = 1; i < parts.length; i++) {
            String name = parts[i];
            if (!cur.children.containsKey(name)) {
                boolean dir = true;
                if (i == parts.length - 1 && !lastDir) {
                    dir = false;
                }
                cur.children.put(name, new File(name,dir));
            }
            cur = cur.children.get(name);
        }
        return cur;
    }

    public List<String> ls(String path) {
        File file = get(path, true);
        List<String> res = new ArrayList<>();
        if (!file.isDir) {
            res.add(file.name);
            return res;
        }
        for (File child: file.children.values()) {
            res.add(child.name);
        }
        Collections.sort(res);
        return res;
    }

    public void mkdir(String path) {
        get(path, true);
    }

    public void addContentToFile(String filePath, String content) {
        File file = get(filePath, false);
        file.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        return get(filePath, false).content.toString();
    }
}