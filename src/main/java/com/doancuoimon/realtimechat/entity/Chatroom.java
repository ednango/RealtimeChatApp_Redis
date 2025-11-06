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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "CHATROOM")
public class Chatroom {
    @Id
    @Column(name = "ID_CHATROOM", nullable = false, length = 20)
    private String idChatroom;

    @Column(name = "NGAYLAP")
    private LocalDate ngaylap;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CHUDE")
    private BackgroundColor idChude;

    @Column(name = "TENCHATROOM", length = 200)
    private String tenchatroom;

    @OneToMany(mappedBy = "idChatroom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages = new ArrayList<>();

    @OneToMany(mappedBy = "idChatroom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChatroomMember> members = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "CHATROOM_USER",
        joinColumns = @JoinColumn(name = "ID_CHATROOM"),
        inverseJoinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "USERID")
    )
    private List<User> chatroomMembers = new ArrayList<>();

}
