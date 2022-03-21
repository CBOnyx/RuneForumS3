package com.example.runeforum.UserService.DAL;

import com.example.runeforum.PostService.DAL.PostEntity;
import com.example.runeforum.ReactionService.DAL.ReactionEntity;
import com.example.runeforum.UserService.Usertype;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Entity @Getter @Setter
public class UserEntity
{
    @Id
    private int ID;

    @Column
    private String Username;

    @Column
    private String Password;

    @Enumerated
    private Usertype Type;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReactionEntity> Reactions;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostEntity> Posts;
}
