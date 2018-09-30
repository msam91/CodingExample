package dropbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileOptimization {

    public static class File {
        public static final Set<String> fNameSet = new HashSet<String>();
        private String fName = null;
        private String fContent = null;

        public File(String fName) throws Exception {
            if (fNameSet.contains(fName)) {
                throw new Exception();
            }
            this.fName = fName;
            fNameSet.add(fName);
        }

        public String getFName() {
            return this.fName;
        }

        public void setFContent(String content) {
            this.fContent = content;
        }

        public String getFContent() {
            return this.fContent;
        }
    }

    public static class Directory {
        private List<File> fileList = null;
        private List<Directory> subDirecories = null;

        public Directory() {
            fileList = new ArrayList<File>();
            subDirecories = new ArrayList<Directory>();
        }

        public void addFiles(File f) {
            fileList.add(f);
        }

        public void addSubDirectory(Directory d) {
            subDirecories.add(d);
        }

        public boolean isEmpty() {
            return fileList.isEmpty() && subDirecories.isEmpty();
        }
    }

    public static void main(String args[]) throws Exception {

        File file1 = new File("f1");
        file1.setFContent("abcd");

        File file5 = new File("f5");
        file5.setFContent("abcd");

        File file3 = new File("f3");
        file3.setFContent("dadawd");

        File file7 = new File("f7");
        file7.setFContent("dadawd");

        File file6 = new File("f6");
        file6.setFContent("pqrs");

        File file2 = new File("f2");
        file2.setFContent("pqrs");

        File file8 = new File("f8");
        file8.setFContent("dadabcawd");
        File file4 = new File("f4");
        file4.setFContent("daff");

        Directory root = new Directory();
        root.addFiles(file8);

        Directory a = new Directory();
        a.addFiles(file1);
        a.addFiles(file2);
        a.addFiles(file3);

        root.addSubDirectory(a);

        Directory b = new Directory();
        b.addFiles(file4);

        Directory d = new Directory();
        d.addFiles(file5);
        d.addFiles(file6);

        Directory e = new Directory();
        d.addSubDirectory(e);

        b.addSubDirectory(d);
        root.addSubDirectory(b);

        Directory c = new Directory();
        c.addFiles(file7);
        root.addSubDirectory(c);

        FileOptimization f = new FileOptimization();
        List<File> result = f.getFilesWithUniqueContent(root);

        for (File file : result) {
            System.out.println(file.getFName());
        }

    }

    public Map<String, List<File>> uniqueFileMap = new HashMap<>();

    public List<File> getFilesWithUniqueContent(Directory root) {
        long sTimebfs = System.currentTimeMillis();
        helper_bfs(root);
        long eTimebfs = System.currentTimeMillis();
        System.out.println(eTimebfs-sTimebfs);
        List<File> result = new ArrayList<FileOptimization.File>();
        for (String s : uniqueFileMap.keySet()) {
            result.addAll(uniqueFileMap.get(s));
        }
        return result;
    }

    public void helper_bfs(Directory parent) {

        if (parent.isEmpty()) {
            return;
        }

        if (!parent.fileList.isEmpty()) {
            for (File f : parent.fileList) {
                constructMap(f);
            }
        }
        if (!parent.subDirecories.isEmpty()) {
            for (Directory d : parent.subDirecories) {
                helper_bfs(d);
            }

        }

    }
    
    public void helper_dfs(Directory parent) {

        if (parent.isEmpty()) {
            return;
        }

        if (!parent.subDirecories.isEmpty()) {
            for (Directory d : parent.subDirecories) {
                helper_dfs(d);
            }

        }

        if (!parent.fileList.isEmpty()) {
            for (File f : parent.fileList) {
                constructMap(f);
            }
        }

    }

    

    public void constructMap(File f) {
        List<File> fileList = null;
        if (!uniqueFileMap.containsKey(f.getFContent())) {
            fileList = new ArrayList<FileOptimization.File>();
            fileList.add(f);
            uniqueFileMap.put(f.getFContent(), fileList);
        }
        else {
            uniqueFileMap.remove(f.getFContent());
        }

    }
}
