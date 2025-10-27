Họ và tên: Lê Ngọc Anh

Mã sinh viên: B25DTCN045

Lớp: D25TXCN05-B

-----


# Bài tập lớn OOP (Java) - Ứng Dụng Quản Lý Thư Viện (QLThuVien)

Một ứng dụng desktop đơn giản được viết bằng Java Swing, cho phép thực hiện các thao tác quản lý sách cơ bản (CRUD) với cơ sở dữ liệu PostgreSQL thông qua JDBC.

-----

## Giới thiệu

Đây là bài tập lớn môn Lập trình Hướng đối tượng (OOP), mục tiêu là làm quen và áp dụng các kiến thức về Java Swing để xây dựng giao diện người dùng và JDBC (Java Database Connectivity) để tương tác với cơ sở dữ liệu quan hệ.

Ứng dụng cho phép người dùng xem, thêm, sửa và xóa thông tin sách trong thư viện từ một giao diện đồ họa trực quan.

## Công nghệ sử dụng

  - **Ngôn ngữ:** [Java](https://www.java.com/en/) (OpenJDK 24)
  - **IDE:** [Apache NetBeans IDE 27](https://netbeans.apache.org/)
  - **Giao diện (UI):** [Java Swing](https://docs.oracle.com/javase/tutorial/uiswing/)
  - **Look and Feel (Theme):** [FlatLaf (FlatLightLaf)](https://www.formdev.com/flatlaf/) & [FlatLaf IntelliJ Themes](https://github.com/JFormDesigner/flatlaf-intellij-themes) - Các thư viện giao diện hiện đại, nhẹ và đẹp mắt cho Swing.
  - **Kết nối CSDL:** [JDBC](https://docs.oracle.com/javase/tutorial/jdbc/index.html) (Java Database Connectivity)
  - **Cơ sở dữ liệu:** [PostgreSQL](https://www.postgresql.org/) - Hệ quản trị cơ sở dữ liệu quan hệ mã nguồn mở mạnh mẽ.

-----

## Tính năng chính

Ứng dụng triển khai đầy đủ 4 thao tác cơ bản của CRUD đối với thông tin sách:

  - **`HIỂN THỊ` (Read):** Tải và hiển thị toàn bộ danh sách sách từ bảng `Sach` trong CSDL PostgreSQL lên `JTable`. Dữ liệu được sắp xếp theo `MaSach`.
  - **`THÊM` (Create):** Thêm một cuốn sách mới vào CSDL. Chương trình có xử lý các ràng buộc:
      - Không cho phép để trống `MaSach` và `TenSach`.
      - Bắt lỗi trùng lặp `MaSach` (Primary Key constraint - SQLState "23505").
      - Bắt lỗi `SoLuong` không phải là số nguyên hoặc là số âm. (Số lượng mặc định là 0 nếu để trống).
  - **`CẬP NHẬT` (Update):** Chọn một cuốn sách từ bảng, thông tin sẽ được nạp lên form (`txtMaSach`, `txtTenSach`...). Người dùng có thể chỉnh sửa các thông tin (ngoại trừ `MaSach`) và nhấn "CẬP NHẬT" để lưu thay đổi vào CSDL.
  - **`XÓA` (Delete):** Chọn một cuốn sách từ bảng và nhấn "XÓA". Chương trình sẽ hiện hộp thoại yêu cầu xác nhận trước khi thực hiện `DELETE`. Xử lý lỗi ràng buộc khóa ngoại (ví dụ: SQLState "23503" nếu sách đang được tham chiếu ở bảng khác).
  - **`RESET`:** Xóa trắng các ô nhập liệu (`JTextField`) trên form, bỏ chọn dòng trên bảng (`JTable`) và cho phép nhập `MaSach` mới.

-----

## Hướng dẫn cài đặt và chạy

Dự án này được xây dựng bằng Apache NetBeans IDE 27.

### Yêu cầu

  - [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) hoặc mới hơn (Project này dùng JDK 24).
  - [Apache NetBeans IDE 27](https://netbeans.apache.org/download/index.html).
  - **PostgreSQL Server:** Cần cài đặt và chạy PostgreSQL Server trên máy tính của bạn (hoặc có quyền truy cập vào một server).

### Các bước chạy

1.  **Clone Repository** (hoặc tải về file ZIP và giải nén):
    https://github.com/Wh7tever/QLThuVien-JavaSwing
  
2.  **Thiết lập Cơ sở dữ liệu PostgreSQL:**
    * Đảm bảo PostgreSQL Server đang chạy.
    * Sử dụng một công cụ quản trị CSDL (như pgAdmin, DBeaver) để tạo một database mới tên là `qltv_db`.
    * Đảm bảo thông tin kết nối trong file `src/database/DBConnection.java` là chính xác (HOST, PORT, DB_NAME, USERNAME, PASSWORD). **Mặc định:** `localhost`, `5432`, `qltv_db`, user `postgres`, pass `admin`. **Hãy thay đổi nếu cần thiết.**
    * *Lưu ý:* Bảng `Sach` sẽ được tự động tạo khi ứng dụng chạy lần đầu nếu chưa tồn tại.

3.  **Mở Project trong NetBeans:**
    * Khởi động NetBeans.
    * Chọn `File` -> `Open Project...`.
    * Trỏ đến thư mục project `QLThuVien` bạn vừa tải về/clone và nhấn `Open Project`.
4.  **Kiểm tra Thư viện:**
    * Project này sử dụng các thư viện ngoài được liệt kê trong mục `Libraries` của NetBeans.
    * Đảm bảo NetBeans đã nhận diện đúng các file JAR sau:
        * `postgresql-42.7.8.jar` (hoặc phiên bản mới hơn)
        * `flatlaf-3.6.2.jar` (hoặc phiên bản mới hơn)
        * `flatlaf-intellij-themes-3.6.2.jar` (hoặc phiên bản mới hơn)
    * Nếu NetBeans báo lỗi (dấu chấm than đỏ ở `Libraries`), hãy chuột phải vào `Libraries` -> `Add JAR/Folder...` và trỏ đến các file `.jar` tương ứng mà bạn đã tải về.

5.  **Chạy ứng dụng:**
    * Tìm file `Main.java` trong package `main`.
    * Chuột phải vào `Main.java` và chọn **`Run File`** (Shift + F6).

> **Lưu ý:** Nếu kết nối CSDL thành công, bảng `Sach` sẽ được tạo (nếu chưa có) và giao diện chính (`LibraryForm`) sẽ hiển thị. Nếu có lỗi kết nối, một hộp thoại thông báo lỗi sẽ xuất hiện.

-----

## Cấu trúc Project

Dự án được tổ chức thành các package cơ bản:

````

QLThuVien/
│
├── nbproject/                 (Thư mục cấu hình của NetBeans)
│
├── src/
│   ├── database/
│   │   └── DBConnection.java    (Quản lý kết nối PostgreSQL, tự động tạo bảng)
│   │
│   ├── main/
│   │   └── Main.java            (Hàm main() để chạy, cài đặt FlatLaf Look and Feel)
│   │
│   └── view/
│       ├── LibraryForm.form     (File thiết kế giao diện của NetBeans)
│       └── LibraryForm.java     (File code xử lý giao diện JFrame và sự kiện)
│
└── build.xml                    (File cấu hình build của Ant)

```

  - **`database.DBConnection.java`**: Class tĩnh (Singleton) quản lý kết nối đến CSDL PostgreSQL. Tự động tạo bảng `Sach` nếu chưa tồn tại khi kết nối lần đầu. Chứa thông tin cấu hình kết nối.
  - **`view.LibraryForm.java`**: Class `JFrame` chính, chứa toàn bộ các thành phần giao diện (text fields, buttons, table) và code xử lý sự kiện (action listeners, table selection listener) để thực hiện các thao tác CRUD thông qua JDBC.
  - **`main.Main.java`**: Class chứa hàm `main()` duy nhất. Nhiệm vụ chính là cài đặt "Look and Feel" (FlatLaf) cho toàn bộ ứng dụng và sau đó khởi tạo, hiển thị `LibraryForm`.
```

