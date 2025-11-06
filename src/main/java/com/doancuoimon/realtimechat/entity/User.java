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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @Column(name = "USERID", nullable = false, length = 20)
    private String userid;

    @Column(name = "USERNAME", unique = true, nullable = false, length = 100)
    private String username;

    @Column(name = "PASSWORD", nullable = false, length = 255)
    private String password;

    @Column(name = "NICKNAME", length = 300)
    private String nickname;

    @OneToMany(mappedBy = "idNguoinhan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChatroomMember> chatroomMembers = new ArrayList<>();

    @OneToMany(mappedBy = "nguoigui")
    private Set<Message> messages = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "chatroomMembers")
    private List<Chatroom> chatrooms = new ArrayList<>();

}
