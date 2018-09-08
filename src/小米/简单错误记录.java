package 小米;

import java.util.*;

/**
 * Created by Wangpl
 * Time 2018/9/8 22:41
 */
public class 简单错误记录 {

    public static void main(String[] args) {
        Map<String, Record> map = new HashMap<>();
        List<Record> recordList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int recordNum = 0;
        boolean flag = false;
        while (input.hasNext()) {
            String str = input.nextLine();
            String[] strings = str.split(" ");
            String filename = strings[0];
            int lineNum = Integer.parseInt(strings[1]);
            if (map.containsKey(filename + lineNum)) {
                Record record = map.get(filename);
                if (lineNum == record.lineNum) {
                    map.replace(filename + lineNum, new Record(record.firstShow, record.lastStr, record.lineNum, record.times));
                    flag = false;
                } else {
                    flag = true;
                }
            } else {
                flag = true;
            }
            if (flag) {
                String lastFileName = filename.substring(filename.indexOf("\\") + 1);
                lastFileName = trimFileName(lastFileName);
                map.put(filename + lineNum, new Record(recordNum, lastFileName, lineNum, 1));
                recordNum++;
                if (recordNum > 8) {
                    break;
                }
            }
        }
        for (Map.Entry<String, Record> recordMap : map.entrySet()) {
            recordList.add(recordMap.getValue());
        }
        Collections.sort(recordList);
        recordList.forEach(System.out::println);
    }

    private static String trimFileName(String lastFileName) {
        if (lastFileName.length() <= 16)
            return lastFileName;
        else
            return lastFileName.substring(lastFileName.length() - 16);
    }

    static class Record implements Comparable<Record>{
        private int firstShow;
        private String lastStr;
        private int lineNum;
        private int times;

        public int getTimes() {
            return times;
        }

        public void setTimes(int times) {
            this.times = times;
        }


        public Record(int firstShow, String lastStr, int lineNum, int times) {
            this.firstShow = firstShow;
            this.lastStr = lastStr;
            this.lineNum = lineNum;
            this.times = times;
        }

        @Override
        public int compareTo(Record o) {
            if (this.lineNum > o.lineNum)
                return 1;
            else if (this.lineNum < o.lineNum) {
                return -1;
            } else {
                return Integer.compare(o.firstShow, this.firstShow);
            }
        }
    }

}
