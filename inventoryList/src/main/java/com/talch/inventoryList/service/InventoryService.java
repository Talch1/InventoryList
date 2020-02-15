package com.talch.inventoryList.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talch.inventoryList.beans.Inventory;
import com.talch.inventoryList.repo.InventoryRepo;

/**
 * 
 * @author Talch
 *
 */

@Service
public class InventoryService {

	@Autowired
	InventoryRepo repo;

	Map<Long, String> detailsMap = new HashMap<Long, String>();

	Map<Long, Integer> depositeMap = new HashMap<Long, Integer>();

	Map<Long, Integer> withdrawalMap = new HashMap<Long, Integer>();

	public InventoryService() {

	}

	public InventoryRepo getRepo() {
		return repo;
	}

	public void setRepo(InventoryRepo repo) {
		this.repo = repo;
	}

	public Map<Long, String> getDetailsMap() {
		return detailsMap;
	}

	public void setDetailsMap(Map<Long, String> detailsMap) {
		this.detailsMap = detailsMap;
	}

	public Map<Long, Integer> getDepositeMap() {
		return depositeMap;
	}

	public void setDepositeMap(Map<Long, Integer> depositeMap) {
		this.depositeMap = depositeMap;
	}

	public Map<Long, Integer> getWithdrawalMap() {
		return withdrawalMap;
	}

	public void setWithdrawalMap(Map<Long, Integer> withdrawalMap) {
		this.withdrawalMap = withdrawalMap;
	}

	@PostConstruct
	public void initDB() {

		List<Inventory> inventoryList = new ArrayList<>();

		inventoryList.add(new Inventory(1, "Pen", 820, 999522455));
		detailsMap.put((long) 1, "This pen is made in USA,color black");
		depositeMap.put((long) 1, 0);
		withdrawalMap.put((long) 1, 0);

		inventoryList.add(new Inventory(2, "Pencil", 530, 999522896));
		detailsMap.put((long) 2, "This pencil is made in Chine,color red");
		depositeMap.put((long) 2, 0);
		withdrawalMap.put((long) 2, 0);

		inventoryList.add(new Inventory(3, "Eraser", 1290, 999522488));
		detailsMap.put((long) 3, "This eraser is made in Chine,it is good to pen and pencil");
		depositeMap.put((long) 3, 0);
		withdrawalMap.put((long) 3, 0);

		inventoryList.add(new Inventory(4, "Notebook", 400, 999522935));
		detailsMap.put((long) 4, "This notebook is made in Chine,it is math notebook");
		depositeMap.put((long) 4, 0);
		withdrawalMap.put((long) 4, 0);

		repo.saveAll(inventoryList);
	}

	public String details(long id) {
		return this.detailsMap.get(id);
	}

	public int deposite(long id) {
		return this.depositeMap.get(id);
	}

	public int withdrawal(long id) {
		return this.withdrawalMap.get(id);
	}

	public Inventory takeItem(Long id) {
		Inventory inventory = repo.getOne(id);
		inventory.setAmount(inventory.getAmount() - 1);
		repo.save(inventory);
		withdrawalMap.replace(id, withdrawalMap.get(id) + 1);
		return inventory;
	}

	public Inventory addItem(Long id) {
		Inventory inventory = repo.getOne(id);
		inventory.setAmount(inventory.getAmount() + 1);
		repo.save(inventory);
		depositeMap.replace(id, (depositeMap.get(id)) + 1);
		return inventory;
	}

	public Inventory addNewItemToList(Inventory item, String details) {
		detailsMap.put(item.getId(), details);
		repo.save(item);
		depositeMap.put(item.getId(), 0);
		withdrawalMap.put(item.getId(), 0);
		return item;
	}

	public Optional<Inventory> getItem(long id) {
		return repo.findById(id);
	}

	public void deleteItem(long id) {
		repo.deleteById(id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((withdrawalMap == null) ? 0 : withdrawalMap.hashCode());
		result = prime * result + ((depositeMap == null) ? 0 : depositeMap.hashCode());
		result = prime * result + ((detailsMap == null) ? 0 : detailsMap.hashCode());
		result = prime * result + ((repo == null) ? 0 : repo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryService other = (InventoryService) obj;
		if (withdrawalMap == null) {
			if (other.withdrawalMap != null)
				return false;
		} else if (!withdrawalMap.equals(other.withdrawalMap))
			return false;
		if (depositeMap == null) {
			if (other.depositeMap != null)
				return false;
		} else if (!depositeMap.equals(other.depositeMap))
			return false;
		if (detailsMap == null) {
			if (other.detailsMap != null)
				return false;
		} else if (!detailsMap.equals(other.detailsMap))
			return false;
		if (repo == null) {
			if (other.repo != null)
				return false;
		} else if (!repo.equals(other.repo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InventoryService [repo=" + repo + ", detailsMap=" + detailsMap + ", depositeMap=" + depositeMap
				+ ", WithdrawalMap=" + withdrawalMap + "]";
	}

}
