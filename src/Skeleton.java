import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Skeleton {

    private static void createSkeleton(String s) throws IOException {
        String[] split = s.split("\\. ");
        createSkeleton(split[1], split[0]);
    }

    private static void createSkeleton(String problemTitle, String problemID) throws IOException {
        StringBuilder sb = new StringBuilder();
        String[] ss = problemTitle.split("[ \\-]");
        for (String sub : ss) {
            if (sub.isEmpty()) {
                continue;
            }
            char[] chars = sub.toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            sb.append(chars);
        }
        System.out.println(sb);

        String pkgName = sb.append("_").append(problemID).toString();
        File d = new File(String.format("src/%s/%s", pkgName.charAt(0), pkgName));
        d.mkdir();
        FileWriter myWriter = new FileWriter(String.format("src/%s/%s/Solution1.java", pkgName.charAt(0), pkgName));
        myWriter.write(String.format("package %s.%s;\n\n", pkgName.charAt(0), pkgName));
        myWriter.write("import java.util.*;\n\n");
        myWriter.write("public class Solution1 {\n// Important constraints:\n}");
        myWriter.close();
    }

    public static void main(String[] args) throws IOException {
        createSkeleton("200008. AAAFind the Index of the First Occurrence in a String");
    }
}
