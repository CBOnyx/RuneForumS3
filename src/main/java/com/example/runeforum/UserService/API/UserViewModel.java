package com.example.runeforum.UserService.API;

import com.example.runeforum.PostService.API.PostViewModel;
import com.example.runeforum.ReactionService.API.ReactionViewModel;
import com.example.runeforum.UserService.Usertype;

import java.util.List;

public class UserViewModel
{
    private int ID;
    private String Username;
    private String Password;
    private Usertype type;
    private List<ReactionViewModel> Reactions;
    private List<PostViewModel> Posts;
}
