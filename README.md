# ParseTable-Optimizer
This java program gets a correct parse table (SLR1 table or LALR1 table) and prints optimized parse table.<br />
Firt enter number of rows and colums , then enter terminals and non-terminals and after that , enter elements of your table.<br />
Example of correct input :<br />
<p>
15 10<br />
+ * ( ) id $ X Z Q W<br />
_ S1 _ _ _ _ _ _ G1 _<br />
R3 _ R3 _ R3 _ _ _ _ _<br />
R6 R6 _ _ R1 _ _ _ _ G2<br />
S2 _ S3 _ S4 _ G2 _ _ _<br />
S11 _ R2 _ R2 _ _ G3 _ _<br />
_ _ R5 R5 _ R5 _ _ _ _<br />
_ S3 _ _ _ _ _ _ _ _<br />
_ _ S6 S6 _ _ _ _ _ _<br />
R3 _ _ _ R3 R3 _ _ _ _<br />
R1 S11 _ R1 R1 R1 _ _ _ G4<br />
R6 R6 _ R6 R6 _ _ _ _ _<br />
S2 _ S2 _ S3 _ _ _ _ _<br />
_ S5 S4 _ _ _ _ G8 G7 _<br />
S9 S9 _ _ _ ACC _ _ _ _<br />
S2 _ S9 _ _ _ _ _ _ _
</p>
