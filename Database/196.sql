# Write your MySQL query statement below
DELETE `P2` FROM `Person` AS `P1`, `Person` AS `P2`
WHERE `P1`.`Email`=`P2`.`Email` AND `P2`.`Id`>`P1`.`Id`;
