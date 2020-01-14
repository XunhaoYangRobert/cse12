Collaborators (write “I did not collaborate with anyone” if you didn't):
Null implementation choice I discussed with Qixuan Ma and Songyu Lu.



Answers to written questions:

Basket0 is buggy because after adding am item to basket the number of items in basket is not 1.

Basket1 is bad implementation choice because its countItem method does not count object with same name and price as the same if they don't reference to same object and it also count null as an item.

Basket2 is bad implementation choice because it only has capacity of 1000 items. It also does not count object with same name and price as the same if they don't reference to same object.

Basket3 is buggy because it remove non-existing item and return true.

Basket4 is buggy because it can add null as an item but cannot remove null.

Basket5 is buggy because its countItem method is incorrect.

Basket6 is bad implementation choice because the capacity of basket only limited to 10 items. 

Basket7 is buggy because its removeallitems method always returns false. 

Basket8 is considered as good functioned class.

Basket9 is bad implementation choice because its countItem method does not count object with same name and price as the same if they don't reference to same object.

Basket10 is buggy because its removeallitems method always returns false and delete other items too. 

Basket11 is buggy because the count of an item can be -1 and cost only counted once for duplicate items. 

Basket12 is buggy because method removeFromBasket return true for already deleted items and count change to -1, and when adding item the arraylist "counts" always add index regardless the item is new item or not.
8
© 2020 GitHub, Inc.