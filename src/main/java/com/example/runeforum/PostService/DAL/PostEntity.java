package com.example.runeforum.PostService.DAL;

import com.example.runeforum.ReactionService.DAL.ReactionEntity;
import com.example.runeforum.ReactionService.ReactionListConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

@Entity @Getter @Setter
public class PostEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long ID;

    @Column
    private String Title;

    @Column
    private String Text;

    @Column
    private ZonedDateTime Date;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReactionEntity> Comments;

    public PostEntity() {}
    public PostEntity(PostDTO postDTO)
    {
        ReactionListConverter converter = new ReactionListConverter();

        this.ID = postDTO.getID();
        Title = postDTO.getTitle();
        Text = postDTO.getText();
        Date = postDTO.getDate();
        Comments = converter.ReactionDTOToReactionEntity(postDTO.getReactions());
    }
}
