CREATE TABLE public.user (
    user_id INT PRIMARY KEY,             
    username VARCHAR(100) NOT NULL      
);
CREATE TABLE public.training_details (
    user_training_id INT PRIMARY KEY,     
    user_id INT NOT NULL,                 
    training_id INT NOT NULL,             
    training_date DATE NOT NULL,          
    FOREIGN KEY (user_id) REFERENCES public.user(user_id)  
);
INSERT INTO public.user (user_id, username) VALUES
(1, 'John Doe'),
(2, 'Jane Don'),
(3, 'Alice Jones'),
(4, 'Lisa Romero');

INSERT INTO public.training_details (user_training_id, user_id, training_id, training_date) VALUES
(1, 1, 1, '2015-08-02'),
(2, 2, 1, '2015-08-03'),
(3, 3, 2, '2015-08-02'),
(4, 4, 2, '2015-08-04'),
(5, 2, 2, '2015-08-03'),
(6, 1, 1, '2015-08-02'),
(7, 3, 2, '2015-08-02'),
(8, 4, 3, '2015-08-03'),
(9, 1, 4, '2015-08-03'),
(10, 3, 1, '2015-08-03'),
(11, 4, 2, '2015-08-04'),
(12, 3, 2, '2015-08-02'),
(13, 1, 1, '2015-08-02'),
(14, 4, 3, '2015-08-03');



SELECT
    td.user_id,
    u.username,
    td.training_id,
    td.training_date,
    COUNT(*) AS count
FROM
    public.training_details td
JOIN
    public.user u
ON
    td.user_id = u.user_id
GROUP BY
    td.user_id, td.training_id, td.training_date, u.username
HAVING
    COUNT(*) > 1
ORDER BY
    td.training_date DESC, td.user_id;