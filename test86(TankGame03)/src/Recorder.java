import java.io.*;
import java.util.Vector;

public class Recorder {
    private static int AllEnemyTankNum = 0;
    public  static BufferedWriter bw = null;
    public  static BufferedReader br = null;
    private static String recordFile = "C:\\Users\\admin\\Desktop\\IDEACode\\TankGameRecorder.txt";
    private static Vector<EnemyTank> enemyTanks = null;
    private static Vector<Node> nodes = new Vector<>();

    public static String getRecordFile() {
        return recordFile;
    }

    public static Vector<Node> GetNodesAndEnemyTankRec() throws IOException {
        br = new BufferedReader(new FileReader(recordFile));
        AllEnemyTankNum = Integer.parseInt(br.readLine());
        String line = "";
        while((line = br.readLine()) != null)
        {
            String[] xyd = line.split(" ");
            Node node = new Node(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]), Integer.parseInt(xyd[2]));
            nodes.add(node);
        }
        br.close();
        return nodes;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static int getAllEnemyTankNum() {
        return AllEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        AllEnemyTankNum = allEnemyTankNum;
    }
    public static void AddAllEnemyTank()
    {
        Recorder.AllEnemyTankNum++;
    }
    public static void KeepRecord() throws IOException {
        bw = new BufferedWriter(new FileWriter(recordFile));
        bw.write(AllEnemyTankNum+"");//这里转成字符串是为了防止文本数字乱码
        bw.newLine();
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if(enemyTank.loop)
            {
                String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirect();
                bw.write(record);
                bw.newLine();
            }
        }
        bw.close();
    }
}
