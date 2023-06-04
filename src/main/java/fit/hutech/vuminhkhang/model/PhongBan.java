package fit.hutech.vuminhkhang.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "phongban")
public class PhongBan
{
    @Id
    @Column(name = "maPhong")
    private String maPhong;

    @Column(name = "tenPB")
    @NotNull(message = "Ten Phong Ban khong duoc de trong")
    private String tenPB;

    @OneToMany(mappedBy = "phongBan", cascade = CascadeType.ALL)
    private List<NhanVien> NhanViens;
}
