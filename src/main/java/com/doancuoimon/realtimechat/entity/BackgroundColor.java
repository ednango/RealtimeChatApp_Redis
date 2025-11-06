/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doancuoimon.realtimechat.entity;

/**
 *
 * @author ADMIN
 */
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MAUNEN")
public class BackgroundColor {
    @Id
    @Column(name = "ID_MAUNEN", nullable = false, length = 20)
    private String idMaunen;

    @Column(name = "TENMAUNEN", length = 200)
    private String tenmaunen;

    @OneToMany(mappedBy = "idChude")
    private List<Chatroom> chatrooms = new ArrayList<>();
}

