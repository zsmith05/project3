CS 2341 – Assignment 3

Zion Smith 49230889
Ivana Ogunbor 49053231

Results:
A product with this ID already exists.
Finished inserting. Insertion took: 233.0 milliseconds.

Enter product id to search: 
c15e7efbe14b9bbcb8b7fe31f9818021
Found product- Product id: c15e7efbe14b9bbcb8b7fe31f9818021, Name= Springbok Puzzles - Christmas Wishes - 400 Piece Jigsaw Puzzle - Large 26.75 Inches by 20.5 Inches Puzzle - Made in USA - Unique Cut Interlocking Pieces - Big Pieces for Kids & Small Pieces for Adults', Category= Toys & Games | Puzzles | Jigsaw Puzzles', Price= $14.95
Search took: 31200.0 nanoseconds.
Would you like to make another search? Type y for yes and n for no.
y

Enter product id to search: 
5bb4a9aa52085ada20006d166b1e2f87
Found product- Product id: 5bb4a9aa52085ada20006d166b1e2f87, Name= Franklin Sports Eye Black Stickers for Kids - Customizable Lettering Baseball and Football Eye Black Stickers - White Pencil Included', Category= Sports & Outdoors | Sports & Fitness | Team Sports', Price= $6.91
Search took: 45800.0 nanoseconds.
Would you like to make another search? Type y for yes and n for no.
y

Enter product id to search: 
a1793c26a96a83a1544300a431e62902
Found product- Product id: a1793c26a96a83a1544300a431e62902, Name= Klutz Decorate This Journal Toy', Category= Toys & Games | Arts & Crafts | Craft Kits', Price= $16.01
Search took: 40700.0 nanoseconds.
Would you like to make another search? Type y for yes and n for no.
n

Process finished with exit code 0

Analysis:  The tree becomes balanced by when a node becomes full (2𝑚−1 products), it is split into two nodes, with the middle product promoted to the parent. This ensures that no node ever has more than 2𝑚−1 products, keeping the tree balanced. When the m was smaller (ex: 2) The insertion process would take alot longer, but the search process would be faster. When m was bigger (ex: 30) The insertion process would speed up, but the search process would be slower. We decided to prioritze the time performace of the insertion over search because even when the search process would be slower, it was still relativly quick ex: (m= 30, search would take an average of 40,000 nanoseconds). This led us to choose the number 30 for m.




