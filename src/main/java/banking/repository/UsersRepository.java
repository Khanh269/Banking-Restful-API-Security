package banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import banking.entity.Users;

public interface UsersRepository extends JpaRepository <Users,Integer>{
	Users findByUserName(String userName);
}
