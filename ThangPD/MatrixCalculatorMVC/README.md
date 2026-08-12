# Matrix Calculator - MVC (theo chuẩn J1.S.P0055)

## Luồng dữ liệu (đúng như hình thầy đưa)

```
Main (Scanner + Validation)
   |
   v
Controller  <-->  Services  <-->  Repository  <-->  Model
   |
   v
View (println kết quả)
```

## Cấu trúc package

| Package      | File(s)                                    | Nhiệm vụ |
|--------------|---------------------------------------------|----------|
| `constants`  | `Message.java`, `Constants.java`             | Toàn bộ message/label và hằng số/enum, không hardcode ở nơi khác |
| `dto`        | `MatrixRequestDTO.java`, `MatrixResponseDTO.java` | RequestDTO: Main → Controller. ResponseDTO: Controller → View |
| `main`       | `Main.java`                                  | Workflow chính. Chỉ nơi duy nhất dùng `Scanner`. Gọi `Validation` để kiểm tra input, sau đó gọi `Controller` |
| `controller` | `MatrixController.java`                      | Nhận `RequestDTO` từ Main, gọi `Services` xử lý nghiệp vụ, đóng gói `ResponseDTO`, gọi `View` hiển thị. Chỉ import DTO, View, Services |
| `services`   | `MatrixServices.java`                        | Tính toán nghiệp vụ (cộng/trừ/nhân ma trận), được phép import `Model`, gọi `Repository` để lưu lịch sử kết quả |
| `repository` | `MatrixRepository.java`                      | Lưu trữ data (lịch sử kết quả tính toán), các method CRUD đơn giản |
| `model`      | `Matrix.java`                                | Chỉ chứa thuộc tính (rows, cols, data) và hành vi mô tả đối tượng (add/subtract/multiply, toString). Không Scanner, không println |
| `utils`      | `Validation.java`                            | Các hàm static validate (isInteger, isInRange). Không dùng Scanner |
| `view`       | `MatrixView.java`                            | Nhận `ResponseDTO`, in kết quả ra console. Không có logic nghiệp vụ |

## So với bản gốc bạn gửi

- `Validator.getInt(...)` (đọc + validate cùng lúc) được tách thành hai phần:
  - `Main.getValidInt(...)`: đọc Scanner, in prompt, in lỗi (I/O)
  - `utils.Validation`: chỉ validate thuần túy (không I/O), đúng tinh thần "Chỗ này phải dùng static method" và Scanner chỉ ở Main
- Logic cộng/trừ/nhân vẫn nằm ở `Model` (vì đó là hành vi của chính đối tượng Matrix), nhưng `Services` là nơi **điều phối nghiệp vụ** (tạo Matrix từ dữ liệu thô, gọi phép tính, lưu vào Repository) — đúng vai trò "Services chỉ được gọi từ Controller, được phép import Model"
- `Repository` được thêm vào để lưu lịch sử các phép tính (trước đây project gốc không có bước lưu trữ nào) — minh họa đúng tầng CRUD như bài mẫu (danh sách sinh viên/bác sĩ → ở đây là lịch sử kết quả)
- `Matrix.toString()` đổi từ nối chuỗi `+=` sang `StringBuilder` cho tối ưu hơn

## Cách chạy

```bash
cd src
javac -d ../out $(find . -name "*.java")
cd ../out
java main.Main
```

> Lưu ý: môi trường sandbox hiện tại không cài được JDK để compile thử do giới hạn mạng,
> nên bạn hãy compile lại trên máy/NetBeans của mình để chắc chắn 100%. Code đã được
> rà soát kỹ về cú pháp và luồng import theo đúng cấu trúc yêu cầu.
