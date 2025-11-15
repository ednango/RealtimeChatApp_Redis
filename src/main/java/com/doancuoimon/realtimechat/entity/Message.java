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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MESSAGE")
public class Message implements Serializable {
    @Id
    @Column(name = "ID_MESSAGE", nullable = false, length = 100)
    private String idMessage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CHATROOM")
    private Chatroom idChatroom;

    @Column(name = "NOIDUNGTN", columnDefinition = "TEXT")
    private String noidungtn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NGUOIGUI")
    private User nguoigui;

    @Column(name = "THOIGIANGUI")
    private Date thoigiangui;

    @OneToMany(mappedBy = "idMessage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attachment> attachments = new ArrayList<>();

}
