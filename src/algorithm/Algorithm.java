package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Algorithm {
    private float[] a;
    private int n;

    public Algorithm() {
    }

    public Algorithm(float[] b) {
        n = b.length;
        a = new float[n];
        for (int i = 0; i < n; i++) {
            a[i] = b[i];
        }
    }
    // ghi mảng vào file
    public void writeArr(float[] a,String file,boolean append){
        String data = "";
        for (int i = 0; i < a.length; i++) {
            data+= a[i] + " ";
        }
        data = data + "\n";
        try {
            FileOutputStream fos = new FileOutputStream(file,append);

            byte[] arr = data.getBytes();
            fos.write(arr);
            fos.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // đọc mảng từ file
    public float[] readArr(String file){

        try {
            FileInputStream fis = new FileInputStream(file);
            Scanner inp = new Scanner(fis,"UTF-8");
            String str = inp.nextLine();
            fis.close();
            String[] arrStr = str.split(" ");
            float[] a = new float[arrStr.length];
            for (int i = 0; i < arrStr.length; i++) {
                a[i] = Float.parseFloat(arrStr[i]);
            }
            return a;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    // hiển thị các phần tử của mảng
    public void display(){
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    // hoán đổi 2 phần tử của mảng
    public void swap(int i, int j){
        float temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    // sắp xếp mảng theo thuật toán bublesort
    public void bubblesort(){
        boolean doicho;
        int i;
        do {
            doicho = false;
            for (i = 0; i < n-1; i++) {
                if (a[i] > a[i+1]){
                    swap(i,i+1);
                    doicho = true;
                }
            }
            writeArr(a,"output.txt",true);
            display();
        } while (doicho);

    }
    //sắp xếp theo thuật toánselectsort
    public void selectSort(){
        int k ;
        for (int i = 0; i < n-1; i++) {
            float min = a[i];k=i;
            for (int j = i+1; j < n ; j++) {
                if (a[j] < min){
                    k = j;
                    min = a[j];
                }
            }
            if (k != i){
                swap(i,k);
            }
            writeArr(a,"output.txt",true);
            display();
        }
    }
    // sắp xếp theo thuật toán chèn
    public void insertSort(){
        int i,j;
        float x;
        for ( i = 1; i < n; i++) {
            x = a[i];
            j=i-1;
            while (j>=0 && x < a[j]){
                a[j+1] = a[j];
                j=j-1;
            }
            a[j+1] = x;
            display();
            writeArr(a,"output.txt",true);
        }
    }
    // tìm kiếm nhị phân
    public void search(float value){
        System.out.print("chỉ số là: ");
        for (int i = 0; i < n; i++) {
            if(a[i] > value){
                System.out.print(i + " ");
            }
        }
    }
    // tìm kiếm nhị phân
    public void binarySearch(float value){
        int left = 0;
        int right = n;
        boolean ok = false;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (a[mid] == value){
                ok = true;
                //tìm vị trí xuất hiện đầu tiên của value
                while (a[mid-1]==value && mid > 0){
                    mid = mid -1;
                }
                System.out.println("index of first element: "+mid);
                return;
            } else if (a[mid]>value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (ok==false){
            System.out.println("element không có trong mảng");
        }
    }
}
