/**
 * 环形数组缓冲区 缓冲区所能存放的数据为缓冲区大小的个数 减去1 为实际能存储的大小
 */

public class demo {
    private byte[] buf = null;
    private int start;
    private int end;

    public demo(int s) {//构造函数定义缓冲区的大小
        buf = new byte[s];
        this.start = this.end = 0;
    }

    public boolean put(byte[] ar) {
        if (end + 1 == start || (start == end && start == 0 && ar.length >= buf.length)) {
            //System.out.println("空间不够"); // 已满||空间不够

            return false;
        } else if (start < end && ar.length >= buf.length - end + start) {
            //System.out.println("空间不够"); //空间不够

            return false;
        } else if (start > end && ar.length >= start - end) {
            //System.out.println("空间不够");//空间不够
            return false;
        } else if (start < end && ar.length < buf.length - end + start) {
            if (ar.length < buf.length - end) {
                System.arraycopy(ar, 0, buf, end, ar.length);
                end = end + ar.length;
            } else {
                System.arraycopy(ar, 0, buf, end, buf.length - end);
                System.arraycopy(ar, ar.length - (buf.length - end), buf, 0, ar.length - (buf.length - end));
                end = ar.length - (buf.length - end);
            }
        } else if (start > end && ar.length < start - end) {
            System.arraycopy(ar, 0, buf, end, ar.length);
            end = end + ar.length;
        } else if (start == end && start == 0 && ar.length < buf.length) {
            start = 0;
            System.arraycopy(ar, 0, buf, start, ar.length);
            end = ar.length;
        }
        return true;
    }

    public byte[] get(int len) {
        byte[] arr = new byte[len];
        if (start < end) {
            if (len <= end - start) {
                System.arraycopy(buf, start, arr, 0, len);
                start = start + len;
                if (start == end) {
                    start = end = 0;
                }
                return arr;
            } else {
                // System.out.println("内容不够，无法提取！");
                return null;
            }
        } else if (start > end) {
            if (len <= buf.length - start) {
                System.arraycopy(buf, start, arr, 0, len);
                start = start + len;
                if (start == end) {
                    start = end = 0;
                }
                return arr;
            } else if (len <= buf.length - start + end) {
                System.arraycopy(buf, start, arr, 0, buf.length - start);
                System.arraycopy(buf, 0, arr, buf.length - start, len - (buf.length - start));
                start = len - (buf.length - start);
                if (start == end) {
                    start = end = 0;
                }
                return arr;
            } else {
                //System.out.println("内容不够，无法提取！");
                return null;
            }
        }
        //System.out.println("内容不够，无法提取！");
        return null;
    }
}