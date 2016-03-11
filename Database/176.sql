

# 使用 MAX 聚焦函数
SELECT MAX(`Salary`) FROM `Employee` WHERE `Salary`<(SELECT MAX(`Salary`) FROM `Employee`);

# 使用 LIMIT m,n => (m, m + n]
# 注意使用 SELECT 嵌套结果为空时返回 NULL
SELECT(SELECT DISTINCT `Salary` FROM `Employee` ORDER BY `Salary` DESC LIMIT 1, 1);