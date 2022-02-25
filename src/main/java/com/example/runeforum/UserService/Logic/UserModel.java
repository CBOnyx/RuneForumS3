package com.example.runeforum.UserService.Logic;

import com.example.runeforum.PostService.Logic.PostModel;
import com.example.runeforum.ReactionService.Logic.ReactionModel;
import com.example.runeforum.UserService.Usertype;

import java.util.List;

public class UserModel
{
    private int ID;
    private String Username;
    private String Password;
    private String CountryCode;
    private Usertype type;
    private List<ReactionModel> Reactions;
    private List<PostModel> Posts;


}
