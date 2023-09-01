import { UserModel } from 'src/app/model/user.model';
import { PostModel } from 'src/app/model/post.model';
export class GroupModel {
  id!: number;
  name!: string;
  descripiton!: string;
  creationDate!: Date;
  posts!: PostModel[];
  user!: UserModel;
}
