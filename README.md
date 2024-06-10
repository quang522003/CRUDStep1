Mô tả dự án:    
Dự án này là một ứng dụng quản lý danh mục được xây dựng bằng Maven. Nó cung cấp các tính năng cơ bản để thêm, sửa đổi và xóa danh mục.    

Cách thiết lập môi trường phát triển
Trước khi bạn bắt đầu, hãy đảm bảo rằng máy tính của bạn đã cài đặt:
- Java Development Kit (JDK) - phiên bản 8 trở lên
- Maven
- Git

Cài đặt:
- B1: Clone dự án    
    Chạy GitBash: git clone https://github.com/quang522003/CRUDStep1.git
- B2: Di chuyển vào thư mục dự án    
    Chạy GitBash: cd CRUDStep1/category-management-service
- B3: Cài đặt dự án Maven    
    Chạy GitBash: mvn install
- B4: Khởi chạy project    
    Chạy GitBash: mvn spring-boot:run    

Các API trong project trên:
-    Xem thông tin tất cả category:
            GET http://localhost:8080/api/v1/categories
-    Xem thông tin category với id:
            GET http://localhost:8080/api/v1/categories/{id}.json
-    Thêm một category mới:
            POST http://localhost:8080/api/v1/categories.json
            Body: { "categoryName": "Tên danh mục" }
-    Sửa category id:
            PUT http://localhost:8080/api/v1/categories/{id}.json
            Body: { "categoryName": "Tên mới của danh mục" }
-    Xóa category với id:
            DElETE http://localhost:8080/api/v1/categories/{id}.json 
-    Health Checks:
            GET http://localhost:8080/api/v1/health
