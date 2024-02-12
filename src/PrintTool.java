public class PrintTool {
    public static void PrintObjects(Object[] objects) {
        for(int i = 0; i < objects.length; i++) {
            if(objects[i] == null) {
                continue;
            }

            System.out.print(objects[i] + " ");
        }
    }
}
