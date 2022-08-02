package algorithm;

import java.util.Scanner;

public class Main {
    Algorithm agt = new Algorithm();
    Scanner sc = new Scanner(System.in);
    float[] b;
    int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main();
        boolean bl = true;
        do {
            System.out.print("-----Menu------\n"+
                    "1. Input\n"+
                    "2. Output\n"+
                    "3. Bubble Sort\n"+
                    "4. Selection Sort\n"+
                    "5. Insert Sort\n"+
                    "6. Search > value\n"+
                    "7. Binary Search = value\n"+
                    "0. Exit\n"
            );
            System.out.println("lựa chọn của bạn la:");
            int choose = sc.nextInt();
            if(choose==1){
                // 1. Input
                m.input();
            } else if (choose==2) {
                //2. Output
                m.output();
            } else if (choose==3) {
                //3.bubb lesort();
                Algorithm algorithm = new Algorithm(m.b);
                algorithm.bubblesort();
            } else if (choose==4) {
                //4. Selection Sort
                Algorithm algorithm = new Algorithm(m.b);
                algorithm.selectSort();
            } else if (choose==5) {
                // Insert Sort
                Algorithm algorithm = new Algorithm(m.b);
                algorithm.insertSort();
            } else if (choose==6) {
                //6. Search > value
                Algorithm algorithm = new Algorithm(m.b);
                System.out.print("nhập giá trị value: ");
                float value = sc.nextFloat();
                algorithm.search(value);
            } else if (choose==7) {
                //7. Binary Search = value
                Algorithm algorithm = new Algorithm(m.b);
                System.out.print("nhập giá trị value: ");
                float value = sc.nextFloat();
                algorithm.insertSort();
                algorithm.binarySearch(value);
            } else if (choose==0) {
                System.out.println("Goodbye!!!!");
                bl = false;
            } else {
                System.out.println("lựa chọn của bạn không hợp lệ");
            }
        } while (bl);

    }
    // nhập giá trị các phần tử của mảng và lưu vào file input
    public void input(){
        System.out.print("Nhập số phần tử của mảng n:");
        n = sc.nextInt();
        float[] a = new float[n];
        System.out.println("Nhập giá tri các phần tử");
        for (int i = 0; i < n; i++) {
            System.out.print("a["+i+"] = ");
            a[i] = sc.nextFloat();
            System.out.println();
        }
        // lưu mảng vào file input.txt

        agt.writeArr(a,"input.txt",false);
    }
    // đọc file và in mảng
    public void output(){
        this.b = agt.readArr("input.txt");
        for (int i = 0; i < n; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }
}
