package xstampp.usermanagement.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Every {@link IUserProject} can by default assign this as its user system so
 * that Unnecessary null checks are prevented.
 * 
 * @author Lukas Balzer
 *
 */
public class EmptyUserSystem implements IUserSystem {

  @Override
  public boolean createUser() {
    return false;
  }

  @Override
  public boolean grantAccessTo(IUser user, AccessRights right) {
    return false;
  }

  @Override
  public UUID getSystemId() {
    return null;
  }

  /**
   * The empty user system gives access by default.
   */
  @Override
  public boolean checkAccess(UUID entryId, AccessRights accessRight) {
    return true;
  }

  @Override
  public boolean checkAccess(AccessRights accessRight) {
    return true;
  }

  @Override
  public List<IUser> getRegistry() {
    return new ArrayList<IUser>();
  }

  @Override
  public boolean deleteUser(UUID userId) {
    return false;
  }

  @Override
  public boolean canDeleteUser(UUID userId) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean canCreateUser() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public UUID getCurrentUserId() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IUser getCurrentUser() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean assignResponsibility(IUser user, UUID responsibility) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean assignResponsibilities(Map<UUID, IUser> responsibilityMap) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean createAdmin() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public String getSystemName() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<UUID> getResponsibilities(UUID userId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isResponsible(UUID userId, UUID entryId) {
    return true;
  }

  @Override
  public boolean isResponsible(UUID entryId) {
    return true;
  }

  @Override
  public boolean assignResponsibility(UUID responsibility) {
    // TODO Auto-generated method stub
    return false;
  }

}
