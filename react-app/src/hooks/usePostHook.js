import axiosInstance from "../lib/axios";

export const usePostData = (url) => {
  const postData = async (data = null) => {
    const response = await axiosInstance.post(url, data);
    return response.data.body
  };

  return { postData };
};
