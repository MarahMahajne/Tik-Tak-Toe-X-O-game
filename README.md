# Tik-Tak-Toe-X-O-game
a tik tak toe game with adjustable board size and tow players X and O.

X-0 Game:

main:
    This function gets a positive integer from the use N, and calls the function manger with the argument N to start
    the game.
    if the input N is not valid or less than 3 it keeps asking for another input until availed one is intend.

manger:
    while the function "finish" is returning false which means that nun of the players won then the game goes on
    and the manger function makes sure that every player plays on turn:
        it  starts by initializing  a counter "rounds" to  1.
        and then if round is odd then its player 1 turn.
        else if round is even its player 2 turn.
        and on each round we update "rounds" to "rounds + 1".
        on each round it calls the function "play" and then prints the board.
        also in each round we keep track of the number of empty spaces left on the board.
        and if the number of empty spaces left is 0 and no one won then its a tie we announce the result and end the game.
    if "finish" function returns true then we check who's turn it was and we announce the winner.


createBoard:
    This function initializes a new board which is a 2D array, and fills the array with "*"
    and returns the board.

play:
    This function gets the input of the position from the user, and makes sure that the input is valid,
    if the input is not valid it keeps asking the player for another input until he inters a valid one.
    the function also checks if position is not taken otherwise it asks for another position and updates
    the board with the new move.

finish:
    This function returns true when one of the player has filled a row ,column, right diagonal or left diagonal
    returns false if not.
    in the inner loop it checks each row and each column if the have a mach in all of the cells.
    in the outer loop we check the right and left diagonal.

printBoard:
     This function prints the board (2D array).
