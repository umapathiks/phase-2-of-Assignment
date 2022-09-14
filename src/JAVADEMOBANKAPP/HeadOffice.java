package JAVADEMOBANKAPP;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HeadOffice {
	static Map<String, Branch> braches = new LinkedHashMap<>();

	public void createNewBranch(String branchId) {
		Branch branch = new Branch();
		branch.setBranchId(branchId);
		braches.put(branchId, branch);
	}

	public Branch getBranchById(String branchId) throws BankException {
		if (!braches.containsKey(branchId)) {
			throw new BankException("No Branch found with given branchId: " + branchId);
		}
		return braches.get(branchId);
	}

	public List<Branch> getAllBranches() {
		List<Branch> allBranches = new ArrayList<>();
		for (String branchId : braches.keySet()) {
			allBranches.add(braches.get(branchId));
		}
		return allBranches;
	}
}
