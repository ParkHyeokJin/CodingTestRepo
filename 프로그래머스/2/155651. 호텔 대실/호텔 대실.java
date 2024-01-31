import java.util.*;
import java.text.*;
class Solution {
    private static final SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
    public int solution(String[][] book_time) {
        int answer = 0;
        List<Room> books = new ArrayList<>();
        for(int i = 0; i < book_time.length; i++){
            long startBookTime = convertStringTimeToMilliseconds(book_time[i][0]);
            long endBookTime = convertStringTimeToMilliseconds(book_time[i][1]);
            books.add(new Room(startBookTime, endBookTime));
        }
        books.sort(Comparator.comparingInt(t -> Math.toIntExact(t.startTime)));

        Queue<Room> bookingQ = new LinkedList<>(books);
        List<Stack<Room>> useRoomList = new ArrayList<>();
        Stack<Room> roomStack = new Stack<>();
        roomStack.add(bookingQ.poll());
        useRoomList.add(roomStack);
        answer++;

        while (!bookingQ.isEmpty()){
            boolean use = false;
            Room nowRoom = bookingQ.poll();
            for (Stack<Room> rooms : useRoomList) {
                Room chkRoom = rooms.peek();
                if (addCleanRoomTime(chkRoom) <= nowRoom.startTime) {
                    rooms.pop();
                    rooms.add(nowRoom);
                    use = true;
                    break;
                }
            }
            if(!use){
                answer++;
                Stack<Room> rs = new Stack<>();
                rs.push(nowRoom);
                useRoomList.add(rs);
            }
        }

        return answer;
    }

    private static long addCleanRoomTime(Room chkRoom) {
        return chkRoom.endTime + (10 * 60 * 1000);
    }

    private long convertStringTimeToMilliseconds(String s) {
        try {
            Date date = sf.parse(s);
            return date.getTime();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    class Room{
        private long startTime;
        private long endTime;

        public Room(long startTime, long endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "Room{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }
}