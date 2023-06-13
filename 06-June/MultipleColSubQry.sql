select empno,ename,mgr,deptno from emp where (mgr,deptno) in
(select mgr,deptno from emp where empno in(7566,7788));
 
 select mgr,deptno from emp where empno in(7566,7788)
 
 select empno,ename,mgr,deptno from emp where (mgr,deptno) <ANY
(select mgr,deptno from emp where empno in(7566,7788)); -- error

 select empno,ename,mgr,deptno from emp where (mgr,deptno) > ANY
(select mgr,deptno from emp where empno in(7566,7788)); -- error

 select empno,ename,mgr,deptno from emp where (mgr,deptno) =ANY
(select mgr,deptno from emp where empno in(7566,7788));

 select empno,ename,mgr,deptno from emp where (mgr,deptno) >ALL -- error
(select mgr,deptno from emp where empno in(7566,7788));

 select empno,ename,mgr,deptno from emp where (mgr,deptno) <ALL -- error
(select mgr,deptno from emp where empno in(7566,7788));