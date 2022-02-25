package com.example.runeforum.UserService.DAL;

import com.example.runeforum.PostService.DAL.PostDTO;
import com.example.runeforum.ReactionService.DAL.ReactionDTO;
import com.example.runeforum.UserService.Usertype;

import java.util.List;

public class UserDTO
{
    private int ID;
    private String Username;
    private String Password;
    private Usertype type;
    private List<ReactionDTO> Reactions;
    private List<PostDTO> Posts;
}
