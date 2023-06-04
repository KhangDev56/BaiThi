package fit.hutech.vuminhkhang.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "nhanvien")
public class NhanVien
{
    @Id
    @Column(name = "maNV")
    private String maNV;

    @Column(name = "tenNV")
    @NotNull(message = "Ten khong duoc de trong")
    private String tenNV;

    @Column(name = "phai")
    private String phai;

    @Column(name = "noiSinh")
    private String noiSinh;

    @ManyToOne
    @JoinColumn(name = "maPhong")
    private PhongBan phongBan;

    @Column(name = "luong")
    @NotNull(message = "Luong khong hop le")
    private int luong;
}
