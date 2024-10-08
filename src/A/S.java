package A;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class S {

    private static void createSkeleton(String s) throws IOException {
        String[] split = s.split("\\. ");
        createSkeleton(split[1], split[0]);
    }

    private static void createSkeleton(String problemTitle, String problemID) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        String[] ss = problemTitle.split("[ \\-]");
        for (String sub : ss) {
            if (sub.length() == 0) {
                continue;
            }
            char[] chars = sub.toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            sb.append(chars);
            sb2.append(chars).append(" ");
        }
        System.out.println(sb);
        System.out.println(sb2);

        String pkgName = sb.append("_").append(problemID).toString();
        File d = new File("src/" + pkgName);
        d.mkdir();
        FileWriter myWriter = new FileWriter("src/" + pkgName + "/Solution1.java");
        myWriter.write("package " + pkgName + ";\n\n");
        myWriter.write("import java.util.*;\n\n");
        myWriter.write("public class Solution1 {\n// Important constraints:\n}");
        myWriter.close();
    }

    public static void main(String[] args) throws IOException {
        createSkeleton("28. Find the Index of the First Occurrence in a String");
    }
}
