package com.example.runeforum.ReactionService.DAL;

import com.example.runeforum.PostService.DAL.PostEntity;
import com.example.runeforum.UserService.DAL.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity @Getter @Setter
public class ReactionEntity
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long ID;

    @Column(length=250, nullable = false, unique = false)
    private String Text;

    @Column
    private ZonedDateTime Date;

    @ManyToOne
    private PostEntity postEntity;

    @ManyToOne
    private UserEntity userEntity;

}
