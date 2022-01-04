package GoldmanSachs;

import java.util.*;
import java.lang.*;
import java.io.*;

// Created by @thesupremeone on 04/01/22
public class SquaresInChessBoard {
    static Long squaresInChessBoard(Long N) {
        return (N*(N+1)*((2*N)+1))/6;
    }
}