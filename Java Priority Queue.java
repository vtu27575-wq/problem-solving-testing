import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<>(
            (a, b) -> {
                int cmp = Double.compare(b.getCGPA(), a.getCGPA());
                if (cmp != 0) return cmp;

                cmp = a.getName().compareTo(b.getName());
                if (cmp != 0) return cmp;

                return Integer.compare(a.getID(), b.getID());
            }
        );

        for (String event : events) {
            String[] parts = event.split(" ");

            if (parts[0].equals("ENTER")) {
                pq.add(new Student(
                    Integer.parseInt(parts[3]),
                    parts[1],
                    Double.parseDouble(parts[2])
                ));
            } else {
                pq.poll();
            }
        }

        List<Student> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        return result;
    }
}
