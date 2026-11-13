package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // Câu 25:
    public static String chuanHoaTen(String s) {
        if (s == null || s.trim().isEmpty()) {
            return "";
        }

        String[] characters = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : characters) {
            if (!word.isEmpty()) {
                String capitalized = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                result.append(capitalized).append(" ");
            }
        }

        return result.toString();
    }

    // =====================
    // Câu 26:
    public static String danhSachDat(String s) {
        if (s == null || s.trim().isEmpty()) {
            return "KHONG CO";
        }

        String[] items = s.split(",");
        List<Student> list = new ArrayList<>();

        for (String item : items) {
            String[] parts = item.trim().split(":");
            if (parts.length == 2) {
                String id = parts[0].trim();
                double score = Double.parseDouble(parts[1].trim());

                if (score >= 5.0) {
                    list.add(new Student(id, score));
                }
            }
        }

        if (list.isEmpty()) {
            return "KHONG CO";
        }

        list.sort((o1, o2) -> {
            if (Double.compare(o2.score, o1.score) != 0) {
                return Double.compare(o2.score, o1.score);
            }
            return o1.id.compareTo(o2.id);
        });

        StringBuilder result = new StringBuilder();
        for (Student st : list) {
            result.append(st.id).append(" ");
        }

        return result.toString().trim();
    }

    // Lớp lưu thông tin sinh viên (câu 26)
    static class Student {
        String id;
        double score;

        public Student(String id, double score) {
            this.id = id;
            this.score = score;
        }
    }

    // =====================
    // Câu 27:
    public static String demChanVaMax(String s) {
        if (s == null || s.trim().isEmpty()) {
            return "0 0";
        }

        String[] parts = s.trim().split("\\s+");
        int countEven = 0;
        Integer maxEven = null;

        for (String part : parts) {
            if (!part.isEmpty()) {
                int num = Integer.parseInt(part);
                if (num % 2 == 0) {
                    countEven++;
                    if (maxEven == null || num > maxEven) {maxEven = num;}
                }
            }
        }

        if (maxEven == null) {
            return countEven + " ";
        }

        return countEven + " " + maxEven;
    }

    // =====================
    // Câu 28:
    public static String kiemTraEmail(String s) {
        if (s == null) {
            return "KHONG HOP LE";
        }

        // Có đúng một ký tự '@': atChar = lastAtChar
        int atChar = s.indexOf('@');
        int lastAtChar = s.lastIndexOf('@');
        if (atChar == -1 || atChar != lastAtChar) {
            return "KHONG HOP LE";
        }

        // Không có dấu cách
        if (s.contains(" ")) {
            return "KHONG HOP LE";
        }

        // Trước '@' không rỗng
        String localPart = s.substring(0, atChar);
        String domainPart = s.substring(atChar + 1);
        if (localPart.isEmpty() || domainPart.isEmpty()) {
            return "KHONG HOP LE";
        }

        // Sau '@' có dấu chấm
        if (!domainPart.contains(".")) {
            return "KHONG HOP LE";
        }

        // Không bắt đầu hoặc kết thúc bằng dấu chấm
        if (domainPart.startsWith(".") || domainPart.endsWith(".")) {
            return "KHONG HOP LE";
        }

        // Không có hai dấu chấm liền nhau
        if (domainPart.contains("..")) {
            return "KHONG HOP LE";
        }

        return "HOP LE";
    }
}
