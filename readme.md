# Practice Java Problems
This is a project tracking the java work that I have done for the past few months. 
I will store notes as I do more practice.
## Git Notes
Parts of local git storage: unstaged area, staging area, commit history.
Whenever any changes are made or new files are added, they are unstaged.
When we do the command ```git add .``` those files are added to the staging area.
Next we do ```git commit -m "<some message>"```. This adds the files to the commit history.
We can combine these two commands if we have no new files and are just tracking modifications with the command ```git commit -am```

Finally, we push those changes to the remote repo using ```git push```.
## JUnit

## Steps for Walking Through an Interview Problem (from Cracking the Coding Interview)
1. understanding the problem, asking questions (1, 2)
2. solving fast, high level, trying examples, walking through them (3, 4, 5)
3. implement, test, clean up code


1. Listen (BUD: Bottlenecks, unneccessary work, duplicated work) weed out unneccessary info, ask questions
2. Example - is your example a special case or edge case, is it big enough (a lot of examples are too small)
3. Brute Force - ASAP, don't worry about optimizing or efficiency yet
4. Optimization.
5. Walk through your approach.
6. Start implementing (do your bruteforce if necessary and time is short)
7. Testing (throwing edge cases, testing arithmetic, null values, etc) finding bugs


Approaches to Solving Problems
 - data structure brainstorm (hash map, set, etc)
 - simplify and generalize